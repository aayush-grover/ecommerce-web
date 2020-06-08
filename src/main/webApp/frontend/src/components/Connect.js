import React, { Component } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faGithub,faInstagram,faLinkedinIn } from '@fortawesome/free-brands-svg-icons'
class Connect extends Component {
    render() {
        return (
            <div className="container-fluid mt-5 bgsocial">
                <div className="row text-center pt-5">
                    <div className="col-12 ">
                    <h1 className="lobfont">Let's Connect</h1>
                    </div>
                    <div className="col-12 social mt-5 pb-5">
                        <a href="https://www.linkedin.com/in/aayush-grover/"><FontAwesomeIcon className="hovericon" icon={faLinkedinIn} color="#0e76a8" width="30" height="30" alt="" /></a>
                        <a href="https://github.com/aayush-grover"><FontAwesomeIcon className="hovericon" icon={faGithub} color="#211F1F" width="30" height="30" alt="" /></a>
                        <a href="https://www.instagram.com/aayush_grover_/"><FontAwesomeIcon className="hovericon" color="#ff0066" icon={faInstagram}  width="30" height="30" alt="" /></a>
                    </div>
                </div>
            </div>
        );
    }
}

export default Connect;