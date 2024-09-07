import React from 'react'
import { FaPencilAlt } from "react-icons/fa";
import { IoIosClose } from "react-icons/io";

const colors = ['bg-red-400', 'bg-yellow-200', 'bg-green-300', 'bg-blue-300']
const getColorIndex = () => Math.floor(Math.random() * colors.length)

function Task() {
  const colorIndex = getColorIndex()
  return (
    <div className={`p-8 w-[350px] h-[300px] rounded-xl m-5 relative ${colors[colorIndex]}`}>
      <div>
        <h2 className='font-semibold text-2xl'>Bath Daily</h2>
        <p className='mt-1.5 text-sm text-justify'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Necessitatibus in iste ea expedita quisquam quae obcaecati culpa minus. Eveniet temporibus nulla molestias iure distinctio neque sint excepturi quos iste rerum!</p>
      </div>
      <div className='absolute right-5 bottom-5'>
        <button className='bg-black p-3 rounded-full'><FaPencilAlt size={"18px"} color='white' /></button>
        <button className='bg-black p-3 rounded-full ml-3'><IoIosClose size={"18px"} color='white' /></button>
      </div>
    </div>
  )
}

export default Task
