
import {Category_constants} from "./CategoryActionCreator";

const initialState = {
    contentLoading:true,
    success:false
}

export default function categoryReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Category_constants.REFRESH_CATEGORY_SUCCEED:
            return {...payload,contentLoading:false,success:true,treeData:buildTreeDataSortedByPriority(payload.data)};
        case Category_constants.UPDATE_CATEGORY:
            return {...state,...payload,treeData:buildTreeDataSortedByPriority(payload.data,payload.latestInsertId)};
        default:
            return state
    }

}

export const buildTreeDataSortedByPriority = (data,latestInsertId) => {
    const children = data.filter(item => item.parent_id).map(item => ({...item,latestInsertId: latestInsertId === item.id})).sort((p1,p2)=>p1.priority>p2.priority?1:-1);
    const parents = data.filter(item => !item.parent_id).map(parent => ({...parent,latestInsertId: latestInsertId === parent.id})).sort((p1,p2)=>p1.priority>p2.priority?1:-1);
    parents.forEach(parent => {
        for (const child of children) {
            if (child.parent_id === parent.id) {
                if (!parent.children)
                    parent.children = [];
                parent.children.push(child);
            }
        }
    })
    return parents;

}