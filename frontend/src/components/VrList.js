import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

import './VrArchiving.css';
import { ReactComponent as PersonFill } from 'bootstrap-icons/icons/person-fill.svg';
import { ReactComponent as CalendarCheck } from 'bootstrap-icons/icons/calendar-check.svg';
import { ReactComponent as ChevronRight } from 'bootstrap-icons/icons/chevron-right.svg';
import { ReactComponent as Eye } from 'bootstrap-icons/icons/eye.svg';



function VrList() {
	const [vrList, setVrList] = useState([]);  
	const navigate = useNavigate();
  
    const handleSeeMoreClick = () => {
	    navigate('/vr');     
     };

    useEffect(() => {
        fetch('http://localhost:8080/') 
            .then(response => response.json())
            .then(data => {
                if (data && Array.isArray(data.vrList)) { 
                    setVrList(data.vrList);
                } else {
                    console.error('Received data is not an array:', data);
                }
            })
            .catch(error => console.error('Error fetching VR list:', error));            
    }, []);
        
    
    return (
	    <div className="main-section">
	    	{/*	vr아카이빙 영역*/}
	        <div className="area-warp">
	            <div className="left-area">
	            <div className="title">vr아카이빙</div>
	            <div className="content">법률이 정하는 주요방위산업체에 종사하는 근로자들의 단체행동권은 법률이 정하는 바에 의하여 이를 제한하거나 인정하지 아니할 수 없다. 대통령·국무총리·국무위원</div>
	            </div>
	            <div className="right-area">
	                <div className="see-more-button-wrapper">
	                    <button className="see-more"onClick={handleSeeMoreClick}>See More<i className="bi bi-arrow-right-short"></i></button>
	                </div>
	            </div>
	        </div>
        <div className="card-warp"> 
            {vrList.map(vr => (
                <div key={vr.boardNo} className="card">
					<img className="card-image" src={`http://localhost:8080/images/${vr.boardFile}`} alt={`${vr.boardTitle} 이미지`} />
					<div className="card-hover-info">
					    <div><PersonFill /> 작성자</div>
					    <div><CalendarCheck /> {new Date(vr.regDate).toLocaleDateString()}</div>
					</div>
                    <div className="card-content">
                        <div className="card-text">{vr.boardContent}</div>
                    </div>
                    <div className="card-stats">
                        <span><Eye /> 250</span>                        
                        <a href="#" className="btn">Read More<ChevronRight /></a>
                    </div>
                </div>
            ))}
        	</div>
        	
        	
        	
        	
        </div>        
    );
}

export default VrList;
