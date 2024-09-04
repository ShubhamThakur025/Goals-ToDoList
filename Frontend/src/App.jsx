import './App.css'
import Sidebar from './components/Sidebar'
import Task from './components/Task'
import UserCard from './components/UserCard'

function App() {
  return (
    <div className="flex flex-start">
      <section className='fixed'>
        <Sidebar />
      </section>
      <section className='p-8 bg-slate-50 '>
        <h1 className='text-5xl font-semibold ml-14'>Goals</h1>
        <p className='text-sm text-slate-500 ml-14 mt-3 text-justify'>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nostrum amet nisi ut debitis, tempora unde iusto quasi ea autem hic dignissimos repellat labore? Ducimus nemo quod earum voluptates corporis reiciendis!</p>
        <hr className='my-5' />
        <div className='ml-10 mt-8 flex flex-wrap justify-between items-center mx-auto'>
          <Task />
          <Task />
          <Task />
          <Task />
        </div>
      </section>
      <section className='absolute top-3 right-3'>
        <UserCard />
      </section>
    </div>
  )
}

export default App
