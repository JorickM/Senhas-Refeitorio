@extends('meals.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Meals</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('meals.create') }}">Add</a>
        </div>
    </div>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>Weekday Code</th>
            <th>Main Dish</th>
            <th>Soup</th>
            <th>Desert</th>
            <th>Url</th>



            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($meals as $meal)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $meal->codWeekday }}</td>
                <td>{{ $meal->mainDish }}</td>
                <td>{{ $meal->soup }}</td>
                <td>{{ $meal->desert }}</td>
                <td>{{ $meal->url }}</td>

                <td>
                    <form action="{{ route('meals.destroy',$meal->codMeal) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('meals.show',$meal->codMeal) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('meals.edit',$meal->codMeal) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection