import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import PriceApp from "./PriceApp";
import RouterApp from "./RouterApp.js";
import TodoList from "./components/todolist/todolist.js";
import registerServiceWorker from "./registerServiceWorker";
import { Provider } from "react-redux";
import store from "./redux/store.js";

import "bootstrap/dist/css/bootstrap.min.css";

//const Application = <TodoList />;
const Application = <RouterApp />;

// <Provider store={store}>
//    <TodoList />
//  </Provider>
ReactDOM.render(Application, document.getElementById("root"));
registerServiceWorker();
