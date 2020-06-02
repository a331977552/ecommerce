
export const Merchant_constants = {
        SIGN_IN:'SIGN_IN',
        SIGN_OUT:'SIGN_OUT',
        UPDATE:'UPDATE'
}
export const Menu_constants = {
    MENU_SELECTED:'MENU_SELECTED'

}


export function selectMenu(pathname) {

    return {
        type:Menu_constants.MENU_SELECTED,
        payload:pathname
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


