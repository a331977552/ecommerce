import React from "react";
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import { Carousel as ResponsiveCarousel } from 'react-responsive-carousel';

import logo from '../logo.svg';
function Carousel(props) {


    return <div style={{width:'100%',height:'100%'}}>
            <img  style={{width:'100%',height:'100%'}}  src={logo}/>

    </div>

}

export default Carousel;