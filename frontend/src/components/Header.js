import React, { useRef } from 'react'; // useRef 추가
import { useNavigate } from 'react-router-dom';


import './landing_page_banner.css';
import logo from './images/logo.png'; 

function Header({ vrArchivingRef, videoBoardRef }) {
	
	   const navigate = useNavigate();

	
	const handleLoginClick = () => {
        alert('로그인 버튼이 클릭되었습니다.');
    };
    
    const handleNavLinkClick = (e, id) => {
	    e.preventDefault(); // 기본 링크 동작 방지
	    if (id === 'VR아카이빙' && vrArchivingRef.current) {
	        vrArchivingRef.current.scrollIntoView({ behavior: 'smooth' });            
	    } else if  (id === '영상게시판' && videoBoardRef.current){
	        videoBoardRef.current.scrollIntoView({ behavior: 'smooth' });         
	    } else if  (id === 'HOME'){
	    	navigate('/'); 
	    } else {
	        alert(`${id} 메뉴가 클릭되었습니다.`);
	        // 다른 id에 대한 처리...
	    }
    };
          
    
	const handleSignupClick = () => {
        alert('회원가입 버튼이 클릭되었습니다.');
    };
    
    const handleLogoClick = () => {
	    navigate('/'); 
    };
    		
    return (
        <header id="header">
            <div className="logo">
				<a onClick={handleLogoClick}>
            		<img src={logo} alt="로고 이미지" />
	            </a>            
            </div>
            <div className="navigation">
                <span onClick={(e) => handleNavLinkClick(e, 'HOME')}>HOME</span>
                <span onClick={(e) => handleNavLinkClick(e, 'VR아카이빙')}>VR아카이빙</span>
                <span onClick={(e) => handleNavLinkClick(e, '영상게시판')}>영상게시판</span>                
                <span onClick={(e) => handleNavLinkClick(e, '디지털조감도')}>디지털조감도</span>
            </div>
            <div className="buttons">
                <button onClick={handleLoginClick}>로그인</button>
                <button onClick={handleSignupClick}>회원가입</button>
            </div>
        </header>
    );
}

export default Header;
