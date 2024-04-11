import React, { useState, useEffect, useRef } from 'react';

import { Routes, Route } from 'react-router-dom';
import VrArchivingBoard from './components/VrArchivingBoard';
import Header from './components/Header';
import Banner from './components/Banner';
import VideoList from './components/VideoList';
import ScrollToTop from './components/ScrollToTop';
import VrList from './components/VrList'; // VrList 컴포넌트를 임포트

// import Footer from './components/Footer';

function App() {
    const vrArchivingRef = useRef(null); 
    const videoBoardRef = useRef(null);
    
    
    const [data, setData] = useState({ vrList: [], videoList: [] });

    useEffect(() => {
        fetch('http://localhost:8080/')
            .then(response => response.json())
            .then(data => setData({ vrList: data.vrList, videoList: data.videoList }))
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div className="App">
            <Routes>
            
                
{/*                <Route path="/" element={
					<Header vrArchivingRef={vrArchivingRef} videoBoardRef={videoBoardRef} />
					<Banner />			
					<VrList />
					<div ref={vrArchivingRef}><VrArchiving /></div>
					<div ref={videoBoardRef}><VideoBoard /></div>
					} />
            */}
                <Route path="/" element={
					
					<div>
						<Header vrArchivingRef={vrArchivingRef} videoBoardRef={videoBoardRef} />
	           			<Banner />				
			            <div ref={vrArchivingRef}><VrList vrList={data.vrList} /></div> 
			            <div ref={videoBoardRef}><VideoList videoList={data.videoList}/></div>
					</div>
					} />
                <Route path="/vr" element={
					<div>
					<Header vrArchivingRef={vrArchivingRef} videoBoardRef={videoBoardRef} />
					<VrArchivingBoard />														
					</div>					
					} />
            </Routes>

            <ScrollToTop />              
        </div>
    );
}

export default App;
