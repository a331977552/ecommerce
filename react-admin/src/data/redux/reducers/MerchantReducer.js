import {Merchant_constants} from "../actionCreators/commonActionCreator";

const initialState = {
    merchant:JSON.parse(localStorage.getItem('merchant')),
    token:localStorage.getItem('token'),
}

export default function merchantReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Merchant_constants.SIGN_IN:
            localStorage.setItem('merchant',JSON.stringify(payload.merchant))
            localStorage.setItem('token',JSON.stringify(payload.token))
            return  {...state,merchant:payload.merchant,token:payload.token}
        case Merchant_constants.UPDATE:
            return  {...state,merchant:payload}
        case Merchant_constants.SIGN_OUT:
            localStorage.removeItem('merchant')
            localStorage.removeItem('token')
            return  {}
        default:
            return {...state}
    }

}