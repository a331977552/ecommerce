import {MenuItemConstraints} from "../actions/componentActionCreators";

const initialState = {
    loading: true,
    success: false,
    categories: [],
    categorySelectedIndex:0,
    cart: {
        totalPrice: 0,
        cartItems: {}
    }
}

export default function menuReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case MenuItemConstraints.UPDATE_MENU_ITEM:
            return updateCart(state, action.payload);
        case MenuItemConstraints.EMPTY_CART:
            return emptyCart(state);
        case MenuItemConstraints.CATEGORY_SELECTED:
            return {...state,categorySelectedIndex:payload.categorySelectedIndex,sender:payload.sender};
        case MenuItemConstraints.INIT_MENU:
            const cartItems = {};
            payload.reduce((products, cate2) => products.concat(cate2.products), []).forEach(product => {
                cartItems[product.id] = {id: product.id, count: 0, product,subPrice:0};
            });
            const selectedCateByDefault = payload[0].id || 0;
            return {
                ...state, loading: false, success: true,
                categories: action.payload,
                cart: {
                    totalPrice: 0,
                    cartItems
                },
                menuListScrollPos: selectedCateByDefault,
                categorySelectedIndex:selectedCateByDefault,
                sender: "none"
            }
    }
    return {
        ...state
    }
}

function emptyCart(state) {
    const cartItems = {...state.cart.cartItems};
    Object.keys(cartItems).forEach(key=>{
        cartItems[key] = {...cartItems[key],count:0,subPrice:0}
    });
    return {...state, cart: { cartItems, totalPrice:0 } }
}

function updateCart(state, payload) {
    const cartItems = {...state.cart.cartItems};
    const count = payload.count < 0 ? 0 : payload.count;
    const item = cartItems[payload.id];
    cartItems[payload.id] = {...item, count ,subPrice:count * item.product.price};
    const totalPrice = Object.values(cartItems).reduce((totalPrice, cartItem) => totalPrice + cartItem.subPrice, 0);
    return {...state, cart: { cartItems, totalPrice }
    }
}