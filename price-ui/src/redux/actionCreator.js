import {
  CHANGE_INPUT_VALUE,
  ADD_TODO_ITEM,
  DELETE_TODO_ITEM
} from "./actionTypes.js";
import { createAction } from "redux-actions";

export const getInputChangeAction = value => ({
  type: CHANGE_INPUT_VALUE,
  value
});

export const addTodoItemAction = () => ({
  type: ADD_TODO_ITEM
});

export const deleteTodoItemAction = index => ({
  type: DELETE_TODO_ITEM,
  index
});
export const addTodoItemAction2 = createAction(
  "ADD_TODO_ITEM2",
  payload => payload,
  () => ({ updatetype: "update" })
);
export const addTodoItemAction3 = createAction(
  "ADD_TODO_ITEM3",
  payload => payload,
  () => ({ updatetype: "replace" })
);
