import {StageConstraints,OrderConstraints} from "../actions/componentActionCreators";

const initialState = {
    loading: true,
    success: false,
}

export default function stageReducer(state = initialState, action) {
    const payload = action.payload;
    switch (action.type) {
        case OrderConstraints.ORDER_COMPLETE:
            return {...state};
    }
    return {
        ...state
    }
}
