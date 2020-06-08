import React, { Component } from 'react';
import './App.css';
import Signup from './components/Signup';
import Login from './components/Login';
import Home from './components/Home';
import Category from './components/Category';
import AddingItem from './components/AddingItem';
import Cart from './components/Cart'
// 
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
class App extends Component {
  render() {
    return (
      <Router>
              <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/register" exact component={Signup} />
                <Route path="/login" exact component={Login} />
                <Route path="/additem" exact component={Category} />
                <Route path="/itemdetails" exact component={AddingItem} />
                <Route path="/cart" exact component={Cart} />
              </Switch>
      </Router>
    );
  }
}

export default App;
