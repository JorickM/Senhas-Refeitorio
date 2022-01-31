@extends('purchases.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Purchases</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('purchases') }}"> Back</a>
        </div>
    </div>
    <table class="table table-bordered">
        <tr>
            <th>Meal Code:</th>
            <td>{{ $purchase->codMeal }}</td>
        </tr>
        <tr>
            <th>User Code:</th>
            <td>{{ $purchase->codUser }}</td>
        </tr>
        <tr>
            <th>FlgUsed:</th>
            <td>{{ $purchase->flgUsed }}</td>
        </tr>
        <tr>

        </tr>
    </table>
@endsection