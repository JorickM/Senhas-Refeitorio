@extends('purchases.layouts.app')

@section('content')


@if ($message = Session::get('success'))
<div class="alert alert-success">
    <p>{{ $message }}</p>
</div>
@endif

@if (Route::has('login'))
<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
    @auth
    <div class="row">
        <div class="col-lg-11 px-5">
            <h2>Show Purchases List.</h2>
        </div>
    </div>
    <div class="container px-4 px-lg-2 my-5">
    <table class="table table-bordered">
        <tr>
            <th>Purchase Code:</th>
            <td>{{ $purchase->codPurchase }}</td>
        </tr>
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
    <br>
    <div class="col-lg-1">
            <a class="btn btn-primary" href="{{ url('purchases') }}"> Back</a>
        </div>
    </div>
    @else
    <div class="container px-4 px-lg-2 my-5">
        <div class="card-body">
            You are not logged in!
            <a href="{{ route('login') }}" class="text-sm text-gray-700 dark:text-gray-500 underline btn btn-info">Log in</a>
        </div>
    </div>
    @endauth
</div>
@endif



@endsection