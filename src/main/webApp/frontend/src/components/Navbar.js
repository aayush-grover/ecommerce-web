import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faShoppingCart } from '@fortawesome/free-solid-svg-icons'
import { Link } from "react-router-dom";
class Navbar extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <Link className="navbar-brand lobfont text-primary" to={"/"}>
                            <FontAwesomeIcon icon={faShoppingCart} color="#0275d8" width="30" height="30" alt="" />
                        {'  '}Digital Store
                  </Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon" />
                    </button>
                    <div className="collapse navbar-collapse" id="navbarText">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <Link className="nav-link active" to={"/"}>
                                    Home
                              </Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to={{
                                    pathname:"/additem",
                                    }}>
                                    Add Item
                              </Link>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#connect">
                                    Contact
                              </a>
                            </li>
                        </ul>
                        {(localStorage.getItem('accessToken') == null) ? (
                            <span>
                                <Link className="btn btn-outline-info my-2 my-sm-0" to={"/login"}>
                            Login
                          </Link>
                        <Link
                            className="btn btn-outline-info my-2 my-sm-0 ml-3"
                            to={"/register"}
                        >
                            Register

                          </Link>
                            </span>
                        )
                        :
                        (
                             <span>Hi, {localStorage.getItem('username')}</span>
                        )}
                        
                    </div>
                </nav>
            </div>
        );
    }
}

export default Navbar;