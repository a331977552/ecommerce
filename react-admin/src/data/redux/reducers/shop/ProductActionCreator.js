
export const Product_constants = {
    DELETE_PRODUCT : "DELETE_PRODUCT",
    ADD_PRODUCT : "ADD_PRODUCT",
    UPDATE_PRODUCT : "UPDATE_PRODUCT",

    ON_PRODUCT_LIST_INIT_SUCCEED:'ON_PRODUCT_LIST_INIT_SUCCEED',
    ON_PRODUCT_LIST_INIT_FAILED:'ON_PRODUCT_LIST_INIT_FAILED',
    ON_PRODUCT_LIST_INIT_RETRY:'ON_PRODUCT_LIST_INIT_RETRY',

    ON_PRODUCT_LIST_REFRESHING_LOADING:'ON_PRODUCT_LIST_REFRESHING_LOADING',
    ON_PRODUCT_LIST_REFRESHING__FAILED:'ON_PRODUCT_LIST_REFRESHING__FAILED',
    ON_PRODUCT_LIST_REFRESHING_SUCCEED:'ON_PRODUCT_LIST_REFRESHING_SUCCEED',


    PRODUCT_ADD_SUCCEED:'PRODUCT_ADD_SUCCEED',
    PRODUCT_ADD_FAILED:'PRODUCT_ADD_FAILED',
    PRODUCT_ADD_RETRY:'PRODUCT_ADD_RETRY',

}

export function LoadingProductListSucceed(data) {
    return {
        type:Product_constants.ON_PRODUCT_LIST_INIT_SUCCEED,
        payload:data
    }
}


export function onProductListRefreshing(data) {
    return {
        type:Product_constants.ON_PRODUCT_LIST_REFRESHING_LOADING,
        payload:data
    }
}
export function onProductListRefreshingSucceed(data) {
    return {
        type:Product_constants.ON_PRODUCT_LIST_REFRESHING_SUCCEED,
        payload:data
    }
}
export function onProductListRefreshingFailed(data) {
    return {
        type:Product_constants.ON_PRODUCT_LIST_REFRESHING__FAILED,
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


export function onProductLoadingFailed(data) {
    return {
        type:Product_constants.ON_PRODUCT_LIST_INIT_FAILED,
        payload:data
    }
}
export function onProductLoadingRetry(data) {
    return {
        type:Product_constants.ON_PRODUCT_LIST_INIT_RETRY,
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