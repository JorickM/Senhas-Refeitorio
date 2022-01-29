<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Meals extends Model
{
    use HasFactory;

    protected $table = 'meals';

    protected $fillable = ['codWeekday', 'mainDish', 'soup', 'desert'];
}
