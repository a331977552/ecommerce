
export const Merchant_constants = {
        SIGN_IN:'SIGN_IN',
        SIGN_OUT:'SIGN_OUT',
        UPDATE:'UPDATE'
}
export const Menu_constants = {
    MENU_SELECTED:'MENU_SELECTED',
    ON_CONTENT_LOADING_ERROR:'ON_CONTENT_LOADING_ERROR',
    ON_CONTENT_RETRY:'ON_CONTENT_RETRY',
    ON_CONTENT_SUCCESS:'ON_CONTENT_SUCCESS'

}


export function selectMenu() {
    return {
        type:Menu_constants.MENU_SELECTED
    }
}
export function onContentRetry(datapath) {
    return {
        type:Menu_constants.ON_CONTENT_RETRY,
        payload:datapath
    }
}

export function onContentLoadingError(datapath) {
    return {
        type:Menu_constants.ON_CONTENT_LOADING_ERROR,
        payload:datapath
    }
}
export function onContentLoadingSuccess(data) {
    return {
        type:Menu_constants.ON_CONTENT_SUCCESS,
        payload:data
    }
}




export function merchantSignIn(data) {
    return {
        type: Merchant_constants.SIGN_IN,
        payload:data,
    }
}

export function merchantSignOut() {
    return {
        type: Merchant_constants.SIGN_OUT
    }
}
export function merchantUpdate(data) {
    return {
        type: Merchant_constants.UPDATE,
        payload:data,
    }
}


