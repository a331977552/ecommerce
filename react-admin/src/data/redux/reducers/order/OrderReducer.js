
import {Order_constants} from "../order/OrderActionCreator";

const initialState = {
    contentLoading:true,
    success:false,
    orderBy: 'create_date',
    by: 'desc',
    data: {items: []},
    sorter:[
        // {value:'update_date',label:'更新时间'},
        // {value:'create_date',label:'创建时间'},
        // {value:'priority',label:'排名'},
        // {value:'price',label:'价格'},
        // {value:'sales_volume',label:'销量'},
        // {value:'quantity_remaining',label:'库存'},
        // {value:'weight',label:'重量'},
    ],
    example: {
        // //all status
        // status: "",
        // //all categories
        // categoryIds: [-1]
    },
    pagination: {},
    previousState: null

}

export default function orderReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Order_constants.REFRESH_ORDER_SUCCEED:
        return {
        ...state, data: payload.data, contentLoading: false, success: true,
                dataPath: payload.dataPath,
                pagination: getPagination(payload.data)
        };
        case Order_constants.REFRESH_ORDER_FAILED:
            return {...state, contentLoading: false, success: false};
        case Order_constants.REFRESH_ORDER_RETRY:
            return {...state, contentLoading: true, success: false};

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