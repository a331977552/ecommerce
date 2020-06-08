
export const Order_constants = {
    DELETE_ORDER : "DELETE_ORDER",
    ADD_ORDER : "ADD_ORDER",
    UPDATE_ORDER : "UPDATE_ORDER",
    REFRESH_ORDER_SUCCEED:'REFRESH_ORDER_SUCCEED',
    REFRESH_ORDER_FAILED:'REFRESH_ORDER_FAILED',
    REFRESH_ORDER_RETRY:'REFRESH_ORDER_RETRY',
}

export function refreshOrderList(data) {
    return {
        type:Order_constants.REFRESH_ORDER_SUCCEED,
        payload:data
    }
}
export function onOrderRefreshFailed(data) {
    return {
        type:Order_constants.REFRESH_ORDER_FAILED,
        payload:data
    }
}
export function onOrderRefreshRetry(data) {
    return {
        type:Order_constants.REFRESH_ORDER_RETRY,
        payload:data
    }
}

export function deleteOrder(data) {
    return {
        type:Order_constants.DELETE_ORDER,
        payload:data
    }
}
export function updateOrder(data) {
    return {
        type:Order_constants.UPDATE_ORDER,
        payload:data
    }
}