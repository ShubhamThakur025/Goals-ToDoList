import React from 'react'
import { IoIosAdd } from "react-icons/io";

function Sidebar() {
    return (
        <div>
            <aside className='h-[100vh] px-3 py-8 border shadow-xl bg-white'>
                <button className='bg-black p-2 rounded-full'>
                    <IoIosAdd color='white' size={"25px"} />
                </button>
            </aside>
        </div>
    )
}

export default Sidebar
