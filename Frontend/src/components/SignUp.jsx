import React, { useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'

function Signup() {
    const [username, setUsername] = useState("");
    const [email, setMail] = useState("");
    const [password, setPassword] = useState("");

    const signup = () => {
        const userData = { username, email, password, tasks: [] }
        axios.post("http://localhost:8080/users", userData)
            .then(result => console.log(result.data))
            .catch(error => console.log(error))

    }

    return (
        <div className='flex flex-col justify-center items-center w-[100vw] h-[100vh] bg-slate-200'>
            <div>
                <h1 className='text-center text-blue-500 text-5xl font-bold mb-3'>GOALS</h1>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Enter your username" className='bg-white shadow w-full rounded p-3 text-sm' />
                <input type="text" value={email} onChange={(e) => setMail(e.target.value)} placeholder="Enter your email" className='mt-3 bg-white shadow w-full rounded p-3 text-sm' />
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Enter your password" className='mt-3 bg-white shadow w-full rounded p-3 text-sm' />
                <div className='w-full flex justify-center items-center'>
                    <button className='rounded text-sm px-5 py-2 bg-blue-500 text-white shadow mt-3' onClick={signup}>Let me in!</button>
                    <Link to='/'><button className='rounded text-sm px-5 py-2 border border-blue-500 border-2 text-blue-500 shadow mt-3 ml-3'>I have an account</button></Link>
                </div>
            </div>
        </div>
    )
}

export default Signup
