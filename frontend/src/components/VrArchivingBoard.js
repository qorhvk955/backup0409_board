import React, { useState, useEffect } from 'react';
import './VrArchivingBoard.css';

function VrArchivingBoard() {
    const [vrList, setVrList] = useState([]);
    const [pageInfo, setPageInfo] = useState({
        currentPage: 1, // 현재 페이지 번호
        totalPages: 1, // 전체 페이지 수
    });

    // 페이지 데이터를 불러오는 함수
    const fetchPageData = (pageNumber) => {
        fetch(`http://localhost:8080/vr?page=${pageNumber}`)
            .then(response => response.json())
            .then(data => {
                setVrList(data.list); // VR 리스트 데이터 업데이트
                setPageInfo({ // 페이징 정보 업데이트
                    currentPage: pageNumber,
                    totalPages: Math.ceil(data.total / data.cv.amount),
                });
            })
            .catch(error => console.error('Error fetching VR list:', error));
    };

    // 컴포넌트 마운트 시 첫 페이지 데이터 로드
    useEffect(() => {
        fetchPageData(1); // 첫 페이지 데이터 불러오기
    }, []);

    return (
        <div className="vrArchivingBoard-wrap">
            <div className="center-wrap">
                <div className="card-wrap">
                    {vrList.map(item => (
                        <div key={item.boardNo} className="card">
                            <img className="card-image" src={`http://localhost:8080/images/${item.boardFile}`} alt={`${item.boardTitle} 이미지`} />
                            <div className="card-body">
                                <h3 className="card-year">{item.boardWriteYear}</h3>
                                <h2 className="card-title">{item.boardTitle}</h2>
                                <p className="card-text">{item.boardContent}</p>
                                <button className="card-button">더 보기</button>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
            <div className="pagination">
                <button
                    disabled={pageInfo.currentPage === 1}
                    onClick={() => fetchPageData(pageInfo.currentPage - 1)}>
                    이전
                </button>
                {Array.from({ length: pageInfo.totalPages }, (_, index) => (
                    <button
                        key={index + 1}
                        className={pageInfo.currentPage === index + 1 ? "active" : ""}
                        onClick={() => fetchPageData(index + 1)}>
                        {index + 1}
                    </button>
                ))}
                <button
                    disabled={pageInfo.currentPage === pageInfo.totalPages}
                    onClick={() => fetchPageData(pageInfo.currentPage + 1)}>
                    다음
                </button>
            </div>
        </div>
        
    );
}

export default VrArchivingBoard;
