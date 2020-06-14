
import {Product_constants} from './ProductActionCreator'
const initialState = {
    contentLoading:true,
    success:false
}


export default function productAddingReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Product_constants.PRODUCT_ADD_SUCCEED:
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
