import React, { Component } from 'react';
import './Home.css';
import ImageSlider from './ImageSlider';
import Technology from './Technology';
import TeamMembers from './TeamMembers';
import Connect from './Connect';
import FixBg from './FixBg';
import Items from './Items';
import Navbar from './Navbar';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faPowerOff } from '@fortawesome/free-solid-svg-icons'
import {faShoppingCart } from '@fortawesome/free-solid-svg-icons';
import { Link } from "react-router-dom";
class Home extends Component {

    handlelogout = () => {
        localStorage.removeItem('accessToken');
        localStorage.removeItem('username');
    }
    render() {
        return (
            <div>
                {(localStorage.getItem('accessToken') != null) ?
                (
                    <div className="logoutbtn">
                    <a href="." onClick={this.handlelogout}><FontAwesomeIcon className="logouticon" icon={faPowerOff} color="red" alt="" /></a>
                </div>  
                )
            :
            (
                <span></span>
            )}

            {(localStorage.getItem('accessToken') != null) ?
                (
                    <div className="cartbtn">
                    <Link exact to={{pathname: "/cart"}}><FontAwesomeIcon className="logouticon" icon={faShoppingCart} color="#0275d8" alt="" /></Link>
                </div>  
                )
            :
            (
                <span></span>
            )}
                 
                 <Navbar accessToken={(localStorage.getItem('accessToken') == null) ? '' : localStorage.getItem('accessToken')} />


                <ImageSlider />



                <Items />

                <Technology />


                <FixBg />

                <TeamMembers />

                <div id="connect"><Connect /></div>



            </div>
        );
    }
}

export default Home;
