
import {Category_constants} from "./CategoryActionCreator";

const initialState = {
    contentLoading:true,
    success:false,
    categoryTreeData:[],
    categories:[]
}

export default function categoryReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Category_constants.REFRESH_CATEGORY_SUCCEED:
            return {...state,contentLoading:false,success:true,categoryTreeData:buildTreeDataSortedByPriority(payload.data),categories:payload.data};
        case Category_constants.REFRESH_CATEGORY_FAILED:
            return {...state,contentLoading:false,success:false};
        case Category_constants.UPDATE_CATEGORY:
            return {...state,...payload,categoryTreeData:buildTreeDataSortedByPriority(payload.data,payload.latestInsertId),categories:payload.data};
        default:
            return state
    }

}

export const buildTreeDataSortedByPriority = (data,latestInsertId) => {
    if(!data)
        console.error("no data exist");
    const children = data.filter(item => item.parent_id).map(item => ({...item,value:item.id,label:item.title,latestInsertId: latestInsertId === item.id})).sort((p1,p2)=>p1.priority>p2.priority?1:-1);
    const parents = data.filter(item => !item.parent_id).map(parent => ({...parent,value:parent.id,label:parent.title,latestInsertId: latestInsertId === parent.id})).sort((p1,p2)=>p1.priority>p2.priority?1:-1);
    parents.forEach(parent => {
        for (const child of children) {
            if (child.parent_id === parent.id) {
                if (!parent.children)
                parent.children = [];
                parent.children.push(child);
            }
        }
    });

    return parents;

}