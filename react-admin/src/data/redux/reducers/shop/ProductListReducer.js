import {Product_constants} from './ProductActionCreator'

const initialState = {
    contentLoading: true,
    success: false,
    orderBy:'update_date',
    by:'desc',
    data:{items:[]},
    example:{status:"IN_STOCK"},
    pagination:{},
    previousState:null
};

export default function productListReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Product_constants.ON_PRODUCT_LIST_INIT_SUCCEED:
            return {
                ...state, data: payload.data, contentLoading: false, success: true,
                dataPath:payload.dataPath,
                pagination: getPagination(payload.data)
            };
        case Product_constants.ON_PRODUCT_LIST_INIT_FAILED:
            return {...state, contentLoading: false, success: false};
        case Product_constants.PRODUCT_ADD_RETRY:
            return {...state, contentLoading: true, success: false};
        case Product_constants.ON_PRODUCT_LIST_REFRESHING_LOADING:
            const orderBy = payload.orderBy || state.orderBy;
            const by = payload.by || state.by;
            const {example, pagination} = payload;
            return {...state,
                previousState:{...state,example:{...state.example}},
                example,
                orderBy,
                by,
                pagination
            };
        case Product_constants.ON_PRODUCT_LIST_REFRESHING__FAILED:
            return {...state.previousState};
        case Product_constants.ON_PRODUCT_LIST_REFRESHING_SUCCEED:
            return {...state,previousState:null, pagination: getPagination(payload.data),data: payload.data,dataPath: payload.dataPath};

        case Product_constants.UPDATE_PRODUCT:
            return {...state,data:{...state.data,items:updateProduct(state.data.items,payload)}};

        default:
            return state
    }
}
function updateProduct(items,target) {
    console.log(items)
    const newItems = [...items];
    const targetIndex= newItems.findIndex(item=>item.id === target.id);
    newItems[targetIndex] = target;
    return newItems;
}

function getPagination(data) {

    return {
        position: ['topRight', 'bottomRight'],
            // hideOnSinglePage: true,
            total:data.totalElements,
            current: data.currentPage+1,
            pageSize: data.pageSize,
            showTotal: total=> `总共  ${total} 件商品`
    };
}
