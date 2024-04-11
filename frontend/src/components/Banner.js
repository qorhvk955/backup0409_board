import React from 'react';
import './landing_page_banner.css'; // CSS 파일 import
import banner from './images/banner.jpg'; 


function Banner() {
    return (
        <div id="banner">           
            <img src={banner} alt="배너 이미지" />
            <div>
            	<input type='text'/>
            </div>
        </div>
    );
}

export default Banner;
