

import {Menu_constants} from "../actionCreators/commonActionCreator";

const initialState = {
    selectedKey:'/'
}

export default function menuReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Menu_constants.MENU_SELECTED:
            return {selectedKey:payload}
        default:

            return {...state}
    }

}

