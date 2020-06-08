import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBold } from '@fortawesome/free-solid-svg-icons'
import { faPowerOff } from '@fortawesome/free-solid-svg-icons'
class Technology extends Component {
    render() {
        return (
            <div className="p-auto mt-5">
                <div className="container p-auto m-auto">
                    <div className="row welcome text-center">
                        <div className="col-12">
                            <h1 className="display-4 lobfont">Technologies Used</h1>
                            <hr className="my-4" />
                        </div>
                        
                        <div className="col-12">
                            <p className="lead">Welcome to my Ecommerce Shopping Website!!
                            A Shopping website which will help user to find perfect and latest products available in the website
                            .Provides an ease way to advertise and sell their products on internet</p>
                        </div>
                    </div>
                </div>
                 <div className="container p-auto m-auto">
                 <div className="row d-flex justify-content-center text-center welcome m-auto p-auto">
                     <div className="col-xs-12 col-sm-6 col-md-4 p-auto mt-5">
                           <img className="" width="100" height="100" src="\logo512.png" alt="profile" />
                           <h3>REACTJS</h3>
                           <p>Build with open-source JavaScript library ReactJs</p> 
                     </div>
                     <div className="col-xs-12 col-sm-6 col-md-4 p-auto mt-5">
                         <FontAwesomeIcon className="icon" icon={faBold} color="black" width="100" height="100" alt="" />
                         <h3>BOOTSTRAP</h3>
                         <p>Build with latest version of Bootstrap 4, React-Bootstrap</p> 
                     </div>
                     <div className="col-xs-12 col-sm-6 col-md-4 p-auto mt-5">
                            <FontAwesomeIcon className="icon" icon={faPowerOff} color="lightgreen"  alt="" />
                           <h3>SPRING-BOOT</h3>
                           <p>Build with open source Java-based framework Spring Boots</p> 
                     </div>
                 </div>
                 <hr className="my-4 mb-5" />
                </div>
             </div>
        );
    }
}

export default Technology;