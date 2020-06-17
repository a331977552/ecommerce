import {Product_constants} from './ProductActionCreator'

const initialState = {
    contentLoading: true,
    success: false,
    orderBy: 'update_date',
    by: 'desc',
    data: {items: []},
    sorter:[
        {value:'update_date',label:'更新时间'},
        {value:'create_date',label:'创建时间'},
        {value:'priority',label:'排名'},
        {value:'price',label:'价格'},
        {value:'sales_volume',label:'销量'},
        {value:'quantity_remaining',label:'库存'},
        {value:'weight',label:'重量'},
    ],
    example: {
        //all status
        status: "",
        //all categories
        categoryIds: [-1]
    },
    pagination: {},
    previousState: null
};

export default function productListReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Product_constants.ON_PRODUCT_LIST_INIT_SUCCEED:
            return {
                ...state, data: payload.data, contentLoading: false, success: true,
                dataPath: payload.dataPath,
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
            return {...state, previousState: {...state, example: {...state.example}}, example, orderBy, by, pagination};
        case Product_constants.ON_PRODUCT_LIST_REFRESHING__FAILED:
            return {...state.previousState};
        case Product_constants.ON_PRODUCT_LIST_REFRESHING_SUCCEED:
            return {...state, previousState: null, pagination: getPagination(payload.data), data: payload.data, dataPath: payload.dataPath};
        case Product_constants.UPDATE_PRODUCT:
            return {...state, data: {...state.data, items: updateProduct(state.data.items, payload)}};
        case Product_constants.UPDATE_PRODUCT_STATUS: {
            //if display all product, then only update status. if it displays only IN_STOCK or OUT OF STOCK, then item needs to be removed.
            const data = {
                ...state.data,
                items: (state.example.status === '' ? updateProduct(state.data.items, payload) : removeProduct(state.data.items, payload))
            };
            return {...state, data, pagination: getPagination(data, state.example.status === '' ? 0 : -1)};
        }

        case Product_constants.ADD_PRODUCT: {
            const data = {...state.data, items: addProduct(state.data.items, payload)};
            return {...state, data, pagination: getPagination(data, 1)};
        }
        case Product_constants.DELETE_PRODUCT:{
            const data = {
                ...state.data,
                items: removeProduct(state.data.items, payload)
            };
            return {...state,data, pagination: getPagination(data, -1),};
        }

        default:
            return state
    }
}

function updateProduct(items, target) {
    const newItems = [...items];
    const targetIndex = newItems.findIndex(item => item.id === target.id);
    newItems[targetIndex] = target;

    return newItems;
}

function removeProduct(items, target) {
    const newItems = [...items];
    const targetIndex = newItems.findIndex(item => item.id === target.id);
    newItems.splice(targetIndex, 1);
    return newItems;
}

function addProduct(items, target) {
    const newItems = [...items];
    newItems.unshift(target);
    return newItems;
}

function getPagination(data, newlyAddedElement = 0) {

    return {
        position: ['topRight', 'bottomRight'],
        // hideOnSinglePage: true,
        total: data.totalElements + newlyAddedElement,
        current: data.currentPage + 1,
        pageSize: data.pageSize,
        showTotal: total => `总共  ${total} 件商品`
    };
}
