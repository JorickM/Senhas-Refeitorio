@extends('logins.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Weekday</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('weekdays') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
    <tr>
            <th>Weekday Code:</th>
            <td>{{ $weekday->codWeekday }}</td>
        </tr>    
    <tr>
            <th>Name:</th>
            <td>{{ $weekday->name }}</td>
        </tr>
        <tr>
            <th>Date:</th>
            <td>{{ $weekday->date }}</td>
        </tr>
    </table>
@endsection