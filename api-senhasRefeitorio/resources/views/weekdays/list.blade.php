@extends('weekdays.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Weekdays</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('weekdays.create') }}">Add</a>
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
            <th>Name</th>
            <th>Date</th>
            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($weekdays as $weekday)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $weekday->codWeekday }}</td>
                <td>{{ $weekday->name }}</td>
                <td>{{ $weekday->date }}</td>
                <td>
                    <form action="{{ route('weekdays.destroy',$weekday->codWeekday) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('weekdays.show',$weekday->codWeekday) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('weekdays.edit',$weekday->codWeekday) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection