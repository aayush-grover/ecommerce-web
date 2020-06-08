import React, { Component } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import './ImageSlider.css';
class ImageSlider extends Component {
    constructor(props) {
        super(props);
        let date = new Date().toLocaleString('en-us', {  weekday: 'long' });
       this.state = {year: date};
      }
       
    
    render() {
        return (
            <div>
                <Carousel className="slider">
                    <Carousel.Item>
                        <img
                            className="d-block w-100 carousel-img img-fluid"
                            src="/images/h3.jpg"
                            alt="First slide"
                        />
                        <Carousel.Caption className="caption">
                            <h3>Welcome To Our Store</h3>
                            <h1><b>You came to the right place!</b></h1>
                            <a href="#letsgo"><button className="btn btn-primary btn-lg mt-3" href="#letsgo" type="button">Let's see</button></a>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="d-block w-100 carousel-img img-fluid"
                            src="/images/h4.jpg"
                            alt="Third slide"
                        />

                        <Carousel.Caption className="caption1">
                            <h2 className="display-3">{this.state.year} Sale!!</h2>
                            <h4>Shopping is Always a Good Idea</h4>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                            className="d-block w-100 carousel-img img-fluid"
                            src="/images/h2.png"
                            alt="Third slide"
                        />
                    </Carousel.Item>
                </Carousel>
            </div>
        );
    }
}

export default ImageSlider;