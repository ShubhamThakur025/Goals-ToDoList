import React from 'react'
import { Link } from "react-router-dom"

function Login() {
    return (
        <div className='flex flex-col justify-center items-center w-[100vw] h-[100vh] bg-slate-200'>
            <div>
                <h1 className='text-center text-blue-500 text-5xl font-bold mb-3'>GOALS</h1>
                <input type="text" placeholder="Enter your username" className='bg-white shadow w-full rounded p-3 text-sm' />
                <input type="password" placeholder="Enter your password" className='mt-3 bg-white shadow w-full rounded p-3 text-sm' />
                <div className='w-full flex justify-center items-center'>
                    <button className='rounded text-sm px-5 py-2 bg-blue-500 text-white shadow mt-3'>Let me in!</button>
                    <Link to='/register'><button className='rounded text-sm px-5 py-2 border border-blue-500 border-2 text-blue-500 shadow mt-3 ml-3'>I don't have an account</button></Link>
                </div>
            </div>
        </div>
    )
}

export default Login
