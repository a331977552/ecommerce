import {StageConstraints} from "../actions/componentActionCreators";

const initialState = {
    loading: true,
    success: false,
}

export default function stageReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case StageConstraints.STAGE_SHOW:
            return {...state};

    }
    return {
        ...state
    }
}
