import logo from './logo.svg';
import './App.css';
import {Routes, Route, Link, BrowserRouter} from 'react-router-dom';
import {useState} from 'react';
import Footer from './components/common/Footer';
function App() {
// 사용자입력값을 넣어줄 데이터 저장 공간 - insert 하러갈 데이터
const [newItem, setNewItem] = useState(
  {  name:"",  price : "",  amount : ""  }
);
// 항목 1개 데이터 저장된 공간 -selectOne
const [item, setItem] = useState(
  {  name:"a",  price : "1000",  amount : "10"  }
);
// 목록 데이터 저장된 공간-selectList
const [items, setItems] = useState(
  [
  {  name:"a",  price : "1000",  amount : "10"  },
  {  name:"b",    price : "2000",    amount : "120"  },
  {  name:"c",    price : "4000",    amount : "20"  }
  // 요기 추가
  ]
);
const onDeleteHandler = (selectedName)=>{
  console.log("onDeleteHandler");
  const filteredItems = items.filter((it)=>{return it.name != selectedName;});
  console.log(filteredItems);
  setItems(filteredItems);
}
const onClickHandler = (e)=>{
  console.log(newItem);
  console.log(items);
  // 기존 데이터값에 새로운 값을 추가하기 - items 사용하는 부분 rendering 다시 됨.
  setItems([...items, newItem]);
  // 입력창 공란으로 만들기 - newItem 값을 변경해야함.
  setNewItem({  name:"",  price : "",  amount : ""  });
}
const onChangeHandler=(e)=>{
  // 지정한 이름과 같은 키의 값을 대입함.
  const {name, value} = e.target;
  console.log("----a");
  console.log(newItem);
  // newItem - useState에 값 변경했지만...
  setNewItem({...newItem, [name]:value});
  // 이시점에 바로 확인 안됨.
  console.log(newItem);
  console.log("----b");
}
// List 
const List=()=>{
  return(
    <div>
      <h1>List</h1>
      <div>
        <table>
          <thead>
            <tr>
              <th>이름</th>
              <th>가격</th>
              <th>수량</th>
            </tr>
          </thead>
          <tbody>
            {  // html 태그사이 중괄호사용하면 js 문법 사용가능해짐. 다시 html코드 출력 return 사용
              items.map((dto) => {
                return(
                  <tr>
                    <th>{dto.name}</th>
                    <th>{dto.price}</th>
                    <th>{dto.amount}</th>
                    <th><input type="button" value="삭제" data-name={dto.name} onClick={ ()=>{onDeleteHandler(dto.name)}  }/></th>
                  </tr>
                );
              })
            }
          </tbody>
        </table>
      </div>
      <div><Link to={"/home"}>Link-홈</Link></div>
      <div><Link to={"/insert"}>Link-추가</Link></div>
    </div>
  );
}
const Insert=()=>{
  return(
    <div>
      <h1>Insert</h1>
      <div>
        <table>
          <thead>
            <tr>
              <th>이름 <input type="text"  name="name" onChange={onChangeHandler} value={newItem.name}/></th>
              <th>가격 <input type="text"  name="price" onChange={onChangeHandler} value={newItem.price}/></th>
              <th>수량 <input type="text"  name="amount" onChange={onChangeHandler} value={newItem.amount}/></th>
              <th>수량 <input type="button" value="리스트에등록" onClick={onClickHandler}/></th>
            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
      </div>
      <div><Link to={"/home"}>Link-홈</Link></div>
      <div><Link to={"/list"}>Link-리스트</Link></div>
    </div>
  );
}
// function 이름이지만 class 급으로 동작하므로 첫글자 대문자
const Home=()=>{
  return(
    <>
      <h1>홈</h1>
      <div><a href="/insert">추가</a></div>
      <div><Link to={"/Insert"}>Link-추가</Link></div>
      <Insert />
      <List/>
      <Footer />
    </>
  );
}
return (
  <BrowserRouter>
    <div className="App">
      <Routes>
        <Route path='/home' element={<Home/>}/>
        <Route path='/list' element={<List/>}/>
        <Route path='/insert' element={<Insert/>}/>
      </Routes>
      <Footer/>
    </div>
  </BrowserRouter>
);
}
export default App;
