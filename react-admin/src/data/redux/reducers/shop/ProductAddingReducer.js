
import {Product_constants} from './ProductActionCreator'
const initialState = {
    categories:[],
    contentLoading:true,
    success:false
}


export default function productAddingReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Product_constants.PRODUCT_ADD_SUCCEED:
            return {...state, categories:buildTreeDataSortedByPriority(payload.data),contentLoading: false,success: true};
        case Product_constants.PRODUCT_ADD_FAILED:
            return {...state, contentLoading: false,success: false};
        case Product_constants.PRODUCT_ADD_RETRY:
            return {...state,  contentLoading: true,success: false};
        default:
            return state
    }

}

/**
 *  value: 'jiangsu',
 label: 'Jiangsu',
 children: [
 {
        value: 'nanjing',
        label: 'Nanjing',
        children: [
          {
            value: 'zhonghuamen',
            label: 'Zhong Hua Men',
          },
        ],
      },
 *
 *
 * @param data
 * @returns {*}
 */

const buildTreeDataSortedByPriority = (data) => {
    const children = data.filter(item => item.parent_id).map(item => ({...item,value:item.id,label:item.title})).sort((p1,p2)=>p1.priority>p2.priority?1:-1);
    const parents = data.filter(item => !item.parent_id).map(parent => ({...parent,value:parent.id,label:parent.title})).sort((p1,p2)=>p1.priority>p2.priority?1:-1);
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