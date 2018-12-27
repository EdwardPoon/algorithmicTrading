import {
  CHANGE_INPUT_VALUE,
  ADD_TODO_ITEM,
  DELETE_TODO_ITEM
} from "./actionTypes.js";
import { handleAction } from "redux-actions";
import { addTodoItemAction2, addTodoItemAction3 } from "./actionCreator.js";

import reduceReducers from "reduce-reducers";

const defaultState = {
  showSesstionTimeoutModalForm: false,
  inputValue: "123",
  list: ["test1", "test2"]
};

const addTodoItemActionReducer2 = handleAction(
  addTodoItemAction2,
  handleAddItemAction,
  defaultState
);
const addTodoItemActionReducer3 = handleAction(
  addTodoItemAction3,
  handleAddItemAction,
  defaultState
);

function handleAddItemAction(previousState, action) {
  let payload = action.payload;
  let meta = action.meta;

  console.log("payload:" + payload);
  console.log("meta:" + meta);

  const newState = JSON.parse(JSON.stringify(previousState));
  newState.list.push(action.payload);
  newState.inputValue = "";
  return newState;
}
// export default
const defaultReducer = (state = defaultState, action) => {
  if (action.type === CHANGE_INPUT_VALUE) {
    const newState = JSON.parse(JSON.stringify(state));
    newState.inputValue = action.value;
    return newState;
  }
  if (action.type === ADD_TODO_ITEM) {
    const newState = JSON.parse(JSON.stringify(state));
    newState.list.push(newState.inputValue);
    newState.inputValue = "";
    return newState;
  }
  if (action.type === DELETE_TODO_ITEM) {
    const newState = JSON.parse(JSON.stringify(state));
    newState.list.splice(action.index, 1); // splice : find the index and delete first 1 of the item
    return newState;
  }

  return state;
};

const reducer = reduceReducers(
  addTodoItemActionReducer2,
  addTodoItemActionReducer3,
  defaultReducer
);

export default reducer;
