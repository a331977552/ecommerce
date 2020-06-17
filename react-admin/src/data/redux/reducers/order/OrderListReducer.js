import {Order_constants} from "../order/OrderActionCreator";

const initialState = {
    contentLoading: true,
    success: false,
    orderBy: 'create_date',

    by: 'desc',
    data: {items: []},
    sorter: [
        // {value:'update_date',label:'更新时间'},
        // {value:'create_date',label:'创建时间'},
        // {value:'priority',label:'排名'},
        // {value:'price',label:'价格'},
        // {value:'sales_volume',label:'销量'},
        // {value:'quantity_remaining',label:'库存'},
        // {value:'weight',label:'重量'},
    ],
    example: {
        start_create_time: null,
        end_create_time: null,
        buyer: null,
        start_update_time:null,
        end_update_time:null,
        order_number:null,
        payment_method:null,
        phone:null,
        status:null,
        user_id:null,
        dining_method:null,
        customer: {}
    },
    pagination: {},
    previousState: null
}

export default function orderListReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Order_constants.INIT_ORDER_LIST_SUCCEED:
            return {
                ...state, data: payload.data, contentLoading: false, success: true,
                dataPath: payload.dataPath,
                pagination: getPagination(payload.data)
            };
        case Order_constants.INIT_ORDER_LIST_FAILED:
            return {...state, contentLoading: false, success: false};
        case Order_constants.INIT_ORDER_LIST_RETRY:
            return {...state, contentLoading: true, success: false};

        case Order_constants.REFRESH_ORDER_LIST_SUCCEED:
            return {...state, previousState: null, pagination: getPagination(payload.data), data: payload.data, dataPath: payload.dataPath};

        case Order_constants.REFRESH_ORDER_LIST_FAILED:
            return {...state.previousState};
        case Order_constants.REFRESH_ORDER_LIST_LOADING:
            const orderBy = payload.orderBy || state.orderBy;
            const by = payload.by || state.by;
            const {example, pagination} = payload;
            return {...state, previousState: {...state, example: {...state.example}}, example, orderBy, by, pagination};


        /*
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



         */

        default:
            return state
    }

}


function getPagination(data, newlyAddedElement = 0) {

    return {
        position: ['topRight', 'bottomRight'],
        // hideOnSinglePage: true,
        total: data.totalElements + newlyAddedElement,
        current: data.currentPage + 1,
        pageSize: data.pageSize,
        showTotal: total => `总共  ${total} 个订单`
    };
}