
export const Order_constants = {
    ADD_ORDER : "ADD_ORDER",
    UPDATE_ORDER : "UPDATE_ORDER",
    UPDATE_EXAMPLE : 'UPDATE_EXAMPLE',

    INIT_ORDER_LIST_SUCCEED:'INIT_ORDER_LIST_SUCCEED',
    INIT_ORDER_LIST_FAILED:'INIT_ORDER_LIST_FAILED',
    INIT_ORDER_LIST_RETRY:'INIT_ORDER_LIST_RETRY',



    REFRESH_ORDER_LIST_LOADING:'REFRESH_ORDER_LIST_LOADING',
    REFRESH_ORDER_LIST_FAILED:'REFRESH_ORDER_LIST_FAILED',
    REFRESH_ORDER_LIST_SUCCEED:'REFRESH_ORDER_LIST_SUCCEED',

}

export function initOrderList(data) {
    return {
        type:Order_constants.INIT_ORDER_LIST_SUCCEED,
        payload:data
    }
}
export function initOrderListFailed(data) {
    return {
        type:Order_constants.INIT_ORDER_LIST_FAILED,
        payload:data
    }
}
export function initOrderListRetry(data) {
    return {
        type:Order_constants.INIT_ORDER_LIST_RETRY,
        payload:data
    }
}


export function refreshOrderListLoading(data) {
    return {
        type:Order_constants.REFRESH_ORDER_LIST_LOADING,
        payload:data
    }
}

export function refreshOrderListFailed(data) {
    return {
        type:Order_constants.REFRESH_ORDER_LIST_FAILED,
        payload:data
    }
}

export function refreshOrderListSucceed(data) {
    return {
        type:Order_constants.REFRESH_ORDER_LIST_SUCCEED,
        payload:data
    }
}
export function updateExample(data) {
    return {
        type:Order_constants.UPDATE_EXAMPLE,
        payload:data
    }
}



export function updateOrder(data) {
    return {
        type:Order_constants.UPDATE_ORDER,
        payload:data
    }
}