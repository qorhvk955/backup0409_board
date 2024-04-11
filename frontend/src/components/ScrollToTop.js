import React, { useState, useEffect } from 'react';
import './ScrollToTop.css'; // 버튼 스타일을 위한 CSS 파일

const ScrollToTop = () => {
  const [isVisible, setIsVisible] = useState(false);

  // 스크롤 감지
  const toggleVisibility = () => {
    if (window.pageYOffset > 300) { // 300px 이상 스크롤되면 버튼 보임
      setIsVisible(true);
    } else {
      setIsVisible(false);
    }
  };

  // 맨 위로 스크롤
  const scrollToTop = () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth' 
    });
  };

  useEffect(() => {
    window.addEventListener('scroll', toggleVisibility);

    return () => {
      window.removeEventListener('scroll', toggleVisibility);
    };
  }, []);

  return (
    isVisible && (
      <button onClick={scrollToTop} className="scroll-to-top">
        ↑ 맨 위로
      </button>
    )
  );
};

export default ScrollToTop;
