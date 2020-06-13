import {Merchant_constants} from "../actionCreators/commonActionCreator";
import {removeUser, setUser} from "../../../utils/UserDataUtils";

const initialState = {
    merchant:JSON.parse(localStorage.getItem('merchant')),
    token:localStorage.getItem('token'),
}

export default function merchantReducer(state = initialState, action) {
    const payload = action.payload;

    switch (action.type) {
        case Merchant_constants.SIGN_IN:
            setUser(payload);
            return  {...state,merchant:payload.merchant,token:payload.token}
        case Merchant_constants.UPDATE:
            return  {...state,merchant:payload}
        case Merchant_constants.SIGN_OUT:
            removeUser();
            return  {}
        default:
            return state
    }

}