

import {Menu_constants} from "../actionCreators/commonActionCreator";

const initialState = {
    contentData:{
    }
}

export default function menuReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case Menu_constants.MENU_SELECTED:
            return {...state,...payload};
        case Menu_constants.ON_CONTENT_LOADING_ERROR:
            return {...state,contentData:{...state.contentData,[payload.dataPath]:{contentLoading: false, success: false, data:null}}}
        case Menu_constants.ON_CONTENT_RETRY:
            return {...state,
                contentData:{...state.contentData,[payload.dataPath]:{contentLoading: true, success: false, data:null}}}
        case Menu_constants.ON_CONTENT_SUCCESS:
            return {...state, contentData:{...state.contentData,[payload.dataPath]:{contentLoading: false, success: true, data:payload.data}}};
        default:
            return state
    }

}

