
export const Product_constants = {
    DELETE_PRODUCT : "DELETE_PRODUCT",
    ADD_PRODUCT : "ADD_PRODUCT",
    UPDATE_PRODUCT : "UPDATE_PRODUCT",

    REFRESH_PRODUCT_LIST_SUCCEED:'REFRESH_PRODUCT_LIST_SUCCEED',
    REFRESH_PRODUCT_LIST_FAILED:'REFRESH_PRODUCT_LIST_FAILED',
    REFRESH_PRODUCT_LIST_RETRY:'REFRESH_PRODUCT_LIST_RETRY',

    PRODUCT_ADD_SUCCEED:'PRODUCT_ADD_SUCCEED',
    PRODUCT_ADD_FAILED:'PRODUCT_ADD_FAILED',
    PRODUCT_ADD_RETRY:'PRODUCT_ADD_RETRY',

}

export function refreshProductList(data) {
    return {
        type:Product_constants.REFRESH_PRODUCT_LIST_SUCCEED,
        payload:data
    }
}

export function onProductAddInitFailed(data) {
    return {
        type:Product_constants.PRODUCT_ADD_FAILED,
        payload:data
    }
}
export function onProductAddInitSuccess(data) {
    return {
        type:Product_constants.PRODUCT_ADD_SUCCEED,
        payload:data
    }
}

export function onProductAddInitRetry(data) {
    return {
        type:Product_constants.PRODUCT_ADD_RETRY,
        payload:data
    }
}


export function onProductRefreshFailed(data) {
    return {
        type:Product_constants.REFRESH_PRODUCT_LIST_FAILED,
        payload:data
    }
}
export function onProductRefreshRetry(data) {
    return {
        type:Product_constants.REFRESH_PRODUCT_LIST_RETRY,
        payload:data
    }
}

export function deleteProduct(data) {
    return {
        type:Product_constants.DELETE_PRODUCT,
        payload:data
    }
}
export function updateProduct(data) {
    return {
        type:Product_constants.UPDATE_PRODUCT,
        payload:data
    }
}