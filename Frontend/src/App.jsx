import './App.css'
import Task from './components/Task'

function App() {
  return (
    <div className="p-8">
      <h1 className='text-5xl font-bold ml-14'>Notes</h1>
      <hr className='my-5'/>
      <section className='ml-10 mt-8 flex flex-wrap justify-between items-center mx-auto'>
        <Task />
        <Task />
        <Task />
        <Task />
      </section>
    </div>
  )
}

export default App
