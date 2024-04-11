import React from 'react';
import { createRoot } from 'react-dom/client'; // React 18에서의 변경된 임포트
import { BrowserRouter as Router } from 'react-router-dom';
import App from './App'; // App 컴포넌트 임포트

const container = document.getElementById('root'); // 컨테이너 DOM 요소 가져오기
const root = createRoot(container); // createRoot를 사용하여 root 생성

root.render(
  <Router>
    <App />
  </Router>
);
