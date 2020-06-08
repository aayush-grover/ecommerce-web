import React, { Component } from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

class TeamMembers extends Component {
    render() {
        return (
            <div className="mx-auto">
                <div className="container mx-auto">
                    <div className="row text-center">
                        <div className="col-12">
                            <h1 className="display-4 lobfont">Meet The Team</h1>
                            <hr className="mt-3" />
                        </div>
                    </div>
                </div>
                <div className="container mt-5 mx-auto">
                    <div className="row d-flex justify-content-around">
                        <Card style={{ width: '18rem' }} className="col-md-3 m-1">
                            <Card.Img variant="top" height="260" src="\images\p1.jpg" />
                            <Card.Body>
                                <Card.Title className="pt-3 font-weight-bold">Aayush Grover</Card.Title>
                                <Card.Text className="mt-3">
                                Full Stack Developer || Fresher || Java, HTML, CSS, Javascript, React, Spring-Boot 
                                </Card.Text>
                                <Button href="https://www.linkedin.com/in/aayush-grover/" className="mt-3" variant="outline-info">Visit Profile</Button>
                            </Card.Body>
                        </Card>
                        <Card style={{ width: '18rem' }} className="col-md-3 m-1">
                            <Card.Img variant="top" height="260" src="\images\p2.jpg" />
                            <Card.Body>
                                <Card.Title className="pt-3 font-weight-bold">Aaradhya</Card.Title>
                                <Card.Text className="mt-3">
                                Full Stack Developer || Fresher || Java, HTML, CSS, Javascript, React, Spring-Boot
                                </Card.Text>
                                <Button href="https://www.linkedin.com/in/aaradhya-prasad-96bb09193/" className="mt-3" variant="outline-info">Visit Profile</Button>
                            </Card.Body>
                        </Card>
                        <Card style={{ width: '18rem' }} className="col-md-3 m-1">
                            <Card.Img  variant="top" height="260" src="\images\p3.jpg" />
                            <Card.Body>
                                <Card.Title className="pt-3 font-weight-bold">Aashish Mehta</Card.Title>
                                <Card.Text className="mt-3">
                                Full Stack Developer || Fresher || Java, HTML, CSS, Javascript, React, Spring-Boot
                                </Card.Text>
                                <Button href="https://www.linkedin.com/in/aashishmehta1/" className="mt-3" variant="outline-info">Visit Profile</Button>
                            </Card.Body>
                        </Card>
                    </div>
                </div>
            </div>
        );
    }
}

export default TeamMembers;