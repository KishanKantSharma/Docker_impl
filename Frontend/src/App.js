import { useEffect, useState } from 'react';
import './App.css';

function App() {

  const [ipaddr, setipaddr] = useState();

  useEffect(() => {
    const fetchIp = async () => {
      try{
        console.log("Fetching client IP Address...")
        var response = await fetch("http://localhost:9091/api/v1/ipaddress");
        
        const ip = await response.text();
        console.log("Response Getting ClientIP:", ip);

        console.log("Client IP Address: ", ip);

        setipaddr(ip)
      }
      catch(err){
        console.error("Error getting IpAddress:", err);
      }
    }

    fetchIp();
  },[]);

  return (
    <div className="App">
      <header className="App-header">
        <p>
          Client IP Address: {ipaddr || "Loading..."}
        </p>
      </header>
    </div>
  );
}

export default App;
