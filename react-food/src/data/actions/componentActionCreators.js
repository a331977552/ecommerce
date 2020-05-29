export  const MenuItemConstraints= {
    UPDATE_MENU_ITEM:'UPDATE_MENU_ITEM',
    EMPTY_CART:'EMPTY_CART',
    CATE_LEFT_SELECTED:'CATE_RIGHT_SELECTED',
    CATE_RIGHT_SELECTED:'CATE_LEFT_SELECTED',
    CATEGORY_SELECTED:'CATEGORY_SELECTED',
    INIT_APP:'INIT_APP'
}




export  const OrderConstraints= {
    ORDER_COMPLETE: 'ORDER_COMPLETE',
    ORDER_FAILED: 'ORDER_FAILED',

}


/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function updateItemInCartAction(data) {
    return {
        type: MenuItemConstraints.UPDATE_MENU_ITEM,
        payload:data,
    }
}
/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function emptyCartAction() {
    return {
        type: MenuItemConstraints.EMPTY_CART,
        payload:null
    }
}

export function initApp(data) {
    return {
        type: MenuItemConstraints.INIT_APP,
        payload:data
    }
}

export function orderComplete(data) {
    return {
        type: OrderConstraints.ORDER_COMPLETE,
        payload:data
    }
}



/**
 * @param data
 * @returns {{item: *, type: string}}
 */
export function onCategorySelected(data) {
    return {
        type: MenuItemConstraints.CATEGORY_SELECTED,
        payload:data
    }
}