import React from 'react';
import './App.css';
import MenuPage from "./MenuPage";
import StagePage from "./StagePage";

import {
    BrowserRouter,
    HashRouter,
    Switch,
    Route,
    Link
} from "react-router-dom";

function App() {
  return (
      <BrowserRouter>

          <Switch>
              <Route path="/menu">
                  <MenuPage/>

              </Route>
              <Route path="/stage">
                  <StagePage/>
              </Route>
              <Route path="/">
                  <div className="App">
                      <header className="App-header">
                          欢迎光临
                      </header>
                      <div style={{minHeight:'90vh',width:'100%',display:'flex',flexDirection:'column'}}>
                          <div style={{flexGrow:1}}></div>
                          <div style={{flexGrow:1,display:'flex',flexDirection:'row'}}>
                              <div style={{flexGrow:1}}></div>
                              <button style={{width:'100px', height:'50px'}}>
                                  <Link to="/menu?eating=1">打包带走</Link>
                              </button>
                              <div style={{flexGrow:1}}></div>
                              <button style={{width:'100px', height:'50px'}}>
                                  <Link to="/menu?takeway=1">堂吃</Link>
                              </button>
                              <div style={{flexGrow:1}}></div>
                          </div>
                          <div style={{flexGrow:1}}></div>

                      </div>
                  </div>
              </Route>
          </Switch>

      </BrowserRouter>
  );
}

export default App;
